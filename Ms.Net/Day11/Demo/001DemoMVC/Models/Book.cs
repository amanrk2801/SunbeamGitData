using Microsoft.EntityFrameworkCore;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace _001DemoMVC.Models
{

    [Table("Book")]
    public class Book
    {
        [Key]
        [Column("ISBN")]
        public int ISBN { get; set; }

        [Column("Title")]
        [StringLength(50)]
        public string Title { get; set; }

    }

    public class EFDBContext : DbContext
    {
        public EFDBContext(DbContextOptions options): base(options)
        {
            
        }
        public DbSet<Book> Books { get; set; }
        public DbSet<Emp> Emps { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer("Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=EFDB;Integrated Security=True;");

            //base.OnConfiguring(optionsBuilder);
        }
    }

}