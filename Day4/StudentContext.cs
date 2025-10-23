using System.Data.Entity;

namespace StudentManagementSystem.Models
{
    public class StudentContext : DbContext
    {
        public DbSet<Student> Students { get; set; }
    }
}
