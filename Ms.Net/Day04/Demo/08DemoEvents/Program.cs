namespace _08DemoEvents
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Student student = new Student();
            student.Name = "Ravi";

            MyDelegate Vikram = new MyDelegate(Alankar);
            MyDelegate Raj = new MyDelegate(Dhaba);

            student.Accepted += Vikram;
            student.Rejected += Raj;

            Console.WriteLine("Bolo!");
            string message = Console.ReadLine();

            student.Propose(message);

        }

        public static void Alankar()
        {
            Console.WriteLine("Happy Party!");
        }

        public static void Dhaba()
        {
            Console.WriteLine("Sad Party!");
        }
    }

    public delegate void MyDelegate();

    public class Student
    {
        private string _Name;
        public string Name
        {
            get { return _Name; }
            set { _Name = value; }
        }
        
        public event MyDelegate Accepted;
        public event MyDelegate Rejected;

        public void Propose(string message)
        {
            if(message == "i am from sunbeam")
            {
                Rejected();
            }
            else
            {
                Accepted();
            }
        }
    }
}
