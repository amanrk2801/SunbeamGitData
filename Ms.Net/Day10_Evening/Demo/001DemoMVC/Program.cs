using _001DemoMVC.Models;
using Microsoft.EntityFrameworkCore;

namespace _001DemoMVC
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);

            //We will now add "EFDBContext" in the DI Container
            //So we can just expect EFDBContext in constructor 
            //of Controller and we can get it directly
            builder.Services.AddDbContext<EFDBContext>((context)=> {
                context.UseSqlServer("Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=EFDB;Integrated Security=True;");
               });


            builder.Services.AddControllersWithViews();

            var app = builder.Build();

            app.UseStaticFiles();

            app.UseRouting();

            app.MapControllerRoute(
                name: "default",
                pattern: "{controller=Home}/{action=Index}/{id?}");

            app.Run();
        }
    }
}
