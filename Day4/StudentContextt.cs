using System.Data.Entity;

namespace StudentWebAPI.Models
{
    public class StudentContext : DbContext
    {
        public DbSet<Student> Students { get; set; }
    }
}
