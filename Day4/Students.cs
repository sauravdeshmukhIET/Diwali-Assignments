using System;
using System.ComponentModel.DataAnnotations;

namespace StudentWebAPI.Models
{
    public class Students
    {
        [Key]
        public int StudentId { get; set; }
        public string Name { get; set; }
        public DateTime BirthDate { get; set; }
        public string Address { get; set; }
        public string SchoolName { get; set; }
        public double Percentage { get; set; }
    }
}
