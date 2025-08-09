using _000DemoMVC.Controllers;

namespace _000DemoMVC
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);

            //builder.Services.AddScoped(typeof(ISpellChecker),
            //                           typeof(EnglishSpellChecker));

            //builder.Services.AddScoped(typeof(ISpellChecker),
            //                          typeof(HindiSpellChecker));

            //builder.Services.AddSingleton(typeof(ISpellChecker),
            //                          typeof(EnglishSpellChecker));


            // Add services to the container.
            builder.Services.AddControllersWithViews();

            var app = builder.Build();

            app.UseStaticFiles();

            app.UseRouting();

            //app.MapControllerRoute(
            //   name: "MyPattern",
            //   pattern: "{controller=Home}/{action=Index}/{id?}/{name?}/{address?}");

            app.MapControllerRoute(
                name: "default",
                pattern: "{controller=Home}/{action=Index}/{id?}");

            app.Run();
        }
    }
}
