
using _000DemoMVC.Controllers.English;
using _000DemoMVC.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Filters;
using System.Diagnostics;

namespace _000DemoMVC.Controllers.English
{
    public class HomeController : Controller
    {
        private ISpellChecker checker = null;
        //public HomeController(ISpellChecker spellChecker)
        //{
        //    checker = spellChecker;
        //}

        //public HomeController(IEnumerable<ISpellChecker> spellCheckers)
        //{
            
        //}


        public override void OnActionExecuting(ActionExecutingContext context)
        {
           
        }

        public override void OnActionExecuted(ActionExecutedContext context)
        {
           
        }


        public ViewResult Index()
        {
            Emp emp = new Emp() { No = 1, Name = "mahesh", Address = "pune" };

            return View("XYZ", emp);
        }
    }

   public interface ISpellChecker
    {
        bool Check(string text);
    }

    public class EnglishSpellChecker: ISpellChecker
    {
        public EnglishSpellChecker()
        {
            
        }
        public bool Check(string text)
        {
            return false;
        }
    }

     public class HindiSpellChecker: ISpellChecker
    {
        public HindiSpellChecker()
        {
            
        }
        public bool Check(string text)
        {
            return false;
        }
    }
}


namespace _000DemoMVC.Controllers.French
{
    public class HomeController : Controller
    {
       // private ISpellChecker checker = null;
        //public HomeController(ISpellChecker spellChecker)
        //{
        //    checker = spellChecker;
        //}

        //public HomeController(IEnumerable<ISpellChecker> spellCheckers)
        //{

        //}


        public override void OnActionExecuting(ActionExecutingContext context)
        {

        }

        public override void OnActionExecuted(ActionExecutedContext context)
        {

        }


        public ViewResult Index()
        {
            Emp emp = new Emp() { No = 1, Name = "mahesh", Address = "pune" };

            return View("XYZ", emp);
        }
    }

}
