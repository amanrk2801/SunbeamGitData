using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _22DemoEF
{
    [Table("Employee")]
	public class Emp
	{
        [Column("No")]
        [Key]
        public int No { get; set; }
        
        [Column("Name")]
        [StringLength(50)]
        public string Name { get; set; }

        [Column("Address")]
        [StringLength(50)]
        public string Address { get; set; }
    }

    [Table("Subject")]
    public class Subject
    {
        [Key]
        [Column("SubjectID")]
        public int SubjectID { get; set; }

        [Column("SubjectName")]
        [StringLength(50)]
        public string SubjectName { get; set; }

        public List<Trainer> Trainers { get; set; }
    }

    [Table("Trainer")]
    public class Trainer
    {
        [Key]
        [Column("TrainerID")]
        public int TrainerID { get; set; }

        [Column("TrainerName")]
        [StringLength(50)]
        public string TrainerName { get; set; }

        public List<Subject> Subjects { get; set; }
    }

    public class EFDBContext: DbContext
    {
        public DbSet<Emp> Emps { get; set; }
        public DbSet<Subject> Subjects { get; set; }
        public DbSet<Trainer> Trainers { get; set; }
        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer("Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=EFDB;Integrated Security=True;");

            //base.OnConfiguring(optionsBuilder);
        }
    }
}




