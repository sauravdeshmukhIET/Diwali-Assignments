using System.Collections.Generic;
using System.Linq;
using System.Web.Http;
using StudentWebAPI.Models;

namespace StudentWebAPI.Controller
{
    public class StudentsControllers : ApiController
    {
        private StudentContext db = new StudentContext();
        [HttpGet]
        [Route("api/students")]
        public IEnumerable<Student> GetAllStudents()
        {
            return db.Students.ToList();
        }
        [HttpGet]
        [Route("api/students/{id}")]
        public IHttpActionResult GetStudentById(int id)
        {
            var student = db.Students.Find(id);
            if (student == null)
                return NotFound();
            return Ok(student);
        }
        [HttpGet]
        [Route("api/students/range/{min}/{max}")]
        public IEnumerable<Student> GetStudentsByRange(double min, double max)
        {
            return db.Students.Where(s => s.Percentage >= min && s.Percentage <= max).ToList();
        }
    }
}
