using _001DemoMVC.Filters;
using Microsoft.AspNetCore.Mvc;

namespace _001DemoMVC.Controllers
{
    public class TestController : Controller
    {
        [SBAuthFilter]
        public IActionResult Index()
        {
            ViewBag.UserName = this.HttpContext.Session.GetString("username");
            return View();
        }
    
        public IActionResult About()
        {
            return View();
        }
    }
}
