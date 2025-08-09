using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using WebApplication1.Models;

namespace WebApplication1.Controllers
{
    public class DemoController : Controller
    {
        // GET: DemoController
        public ActionResult Index()
        {
            var emps = new List<Emp>() 
            {
              new Emp(){ No = 1, Name = "abc1", Address = "Pune" },
              new Emp(){ No = 2, Name = "abc2", Address = "Pune2" }
            };
            return View(emps);
        }

        // GET: DemoController/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: DemoController/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: DemoController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: DemoController/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: DemoController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: DemoController/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: DemoController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }
    }
}
