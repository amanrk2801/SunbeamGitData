using _001DemoMVC.Models;
using Microsoft.AspNetCore.Mvc;

namespace _001DemoMVC.Controllers
{
    public class HomeController : Controller
    {
        //When we define the below object of EFDBContext
        //Default constructor is called 
        //and OnConfiguring Method of the EFDBContext class gets called.
        //EFDBContext db = new EFDBContext();

        private EFDBContext db = null;

        //When we get EFDBContext via Dependency Injection
        //Internally "builder.Services.AddDbContext<EFDBContext>"
        //calls parameteried constructor which accepts 
        //options to set Connection String
        public HomeController(EFDBContext _db)
        {
            db = _db;
        }
        public IActionResult Index()
        {
            List<Emp> emps =  db.Emps.ToList();

            return View("Index",emps);
        }

        public IActionResult Edit(int id)
        {
            Emp emp = db.Emps.Find(id);
            return View(emp);
        }

        public IActionResult Delete(int id)
        {
            Emp emp = db.Emps.Find(id);
            db.Emps.Remove(emp);
            db.SaveChanges();

            return Redirect("/Home/Index");
        }

        public IActionResult AfterEdit(Emp empUpdated)
        {
            Emp emp = db.Emps.Find(empUpdated.No);
            emp.Name = empUpdated.Name;
            emp.Address = empUpdated.Address;

            db.SaveChanges();

            return Redirect("/Home/Index");
        }

        [HttpGet]
        public IActionResult Create()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Create(Emp emp)
        {

            db.Emps.Add(emp);
            db.SaveChanges();

            return Redirect("/Home/Index");
        }
    }
}
