using _001DemoMVC.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Filters;
using _001DemoMVC.Filters;
namespace _001DemoMVC.Controllers
{
    //[LogFilter]
    public class DemoController : BaseController
    {
        EFDBContext context = null;
        public DemoController(EFDBContext _context)
        {
            context = _context;
        }


//        [LogFilter]
        public ActionResult Index()
        {
            return View(context.Emps.ToList());
        }

       // [LogFilter]
        public ActionResult Create()
        {
            return View();
        }

        // POST: DemoController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
       // public ActionResult Create(IFormCollection collection)
       public ActionResult Create(Emp emp)
        {
            if(ModelState.IsValid)
            {
                context.Emps.Add(emp);
                context.SaveChanges();
                return Redirect("/Demo/Index");
            }
            else
            {
                return View(emp);
            }

        }

        // GET: DemoController/Edit/5
        public ActionResult Edit(int id)
        {
            Emp empToEdit = context.Emps.Find(id);

            return View(empToEdit);
        }

        // POST: DemoController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(Emp empUpdated)
        {
            if (ModelState.IsValid)
            {
                Emp empToEdit = context.Emps.Find(empUpdated.No);
                empToEdit.Name = empUpdated.Name;
                empToEdit.Address = empUpdated.Address;

                context.SaveChanges();
                return Redirect("/Demo/Index");
            }
            else
            {
                return View(empUpdated);
            }
        }

        // GET: DemoController/Delete/5
        public ActionResult Delete(int id)
        {
            Emp empToDelete = context.Emps.Find(id);
            context.Emps.Remove(empToDelete);
            context.SaveChanges();
            return Redirect("/Demo/Index");
        }

    }
}
