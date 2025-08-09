using _001DemoMVC.Models;
using Microsoft.AspNetCore.Mvc;

namespace _001DemoMVC.Controllers
{
    public class ReplyController : Controller
    {
        public IActionResult M1()
        {
            return View("MyView");
        }
        public IActionResult M2()
        {
            return new ContentResult() { Content = "This is just plain message",
                                         ContentType = "text/plain"};
        }

        public IActionResult M3()
        {
            Emp emp = new Emp() { No = 99, Name = "Rohit", Address = "Pune"};
            return new JsonResult(emp);
        }


    }
}
