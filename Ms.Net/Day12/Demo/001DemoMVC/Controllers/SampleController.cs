using Microsoft.AspNetCore.Mvc;
using _001DemoMVC.Models;
using Microsoft.Build.Framework;
namespace _001DemoMVC.Controllers
{
    public class SampleController : Controller
    {
        public IActionResult Index()
        {
            Emp emp = new Emp() { Name = "abc", Address = "pune" };
            Book book = new Book() { ISBN = 9898, Title = "Let us C" };
            string message = "This is a test message";


            //ViewData["MyMessage"] = message;
            ViewBag.MyBook = book;
            ViewBag.MyMessage = message;
            ViewBag.TitleOfTheUI = "Welcome Home!";


            return View(emp);
        }
    }
}
