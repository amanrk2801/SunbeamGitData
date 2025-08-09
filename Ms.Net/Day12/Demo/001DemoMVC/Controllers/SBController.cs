using Microsoft.AspNetCore.Mvc;

namespace _001DemoMVC.Controllers
{
    public class SBController : Controller
    {
        public IActionResult Index()
        {
            ViewBag.Title = "Home!";
            return View();
        }

        public IActionResult About()
        {
            ViewBag.Title = "About Us!";
            return View();
        }

        public IActionResult Contact()
        {
            ViewBag.Title = "Contact Us!";
            return View();
        }
    }
}
