using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;
using _001DemoMVC.Helpers;

namespace _001DemoMVC.Models
{
    [Table("Employee")]
    public class Emp
    {
        [Key]
        [Column("No")]

        public int No { get; set; }

        [Column("Name")]
        [StringLength(50)]
        [Required(ErrorMessage = "Name is required.")]
        [SBValidation(ErrorMessage ="There is a number in name")]
        public string Name { get; set; }

        [Column("Address")]
        [StringLength(50)]
        [Required(ErrorMessage = "Address is required.")]
        public string Address { get; set; }
    }
}
