namespace _02DemoOOP
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("1: PDF, 2: DOCX, 3: TEXT, 4: PPTX");
            int choice = Convert.ToInt32(Console.ReadLine());

            ReportFactory reportFactory = new ReportFactory();
            Report report = reportFactory.GetReport(choice);
            report.GenerateReport();


            
            Console.ReadLine();
        }
     
    }
    public abstract class Report
    {
        protected abstract void Create();
        protected abstract void Parse();
        protected abstract void Validate();
        protected abstract void Save();

       
        public virtual void GenerateReport()
        {
            Create();
            Parse();
            Validate();
            Save();
        }

    }
    public  abstract class  SpecialReport : Report
    {
        protected abstract void ReValidate();
        public override void GenerateReport()
        {
            Create();
            Parse();
            Validate();
            ReValidate();
            Save();
        }
    }
    public class PDF : Report
    {
        protected override void Create()
        {
            Console.WriteLine("PDF Created");
        }
        protected override void Parse()
        {
            Console.WriteLine("PDF Parsed");
        }
        protected override void Validate()
        {
            Console.WriteLine("PDF Validated");
        }
        protected override void Save()
        {
            Console.WriteLine("PDF Saved");
        }

    }
    public class DOCX : Report
    {
        protected override void Create()
        {
            Console.WriteLine("DOCX Created");
        }
        protected override void Parse()
        {
            Console.WriteLine("DOCX Parsed");
        }
        protected override void Validate()
        {
            Console.WriteLine("DOCX Validated");
        }
        protected override void Save()
        {
            Console.WriteLine("DOCX Saved");
        }

       
    }
    public class TEXT : Report
    {
        protected override void Create()
        {
            Console.WriteLine("TEXT Created");
        }

        protected override void Parse()
        {
            Console.WriteLine("TEXT Parsed");
        }

        protected override void Save()
        {
            Console.WriteLine("TEXT Saved");
        }

        protected override void Validate()
        {
            Console.WriteLine("TEXT Validated");
        }
    }
    public class PPTX : SpecialReport
    {
        protected override void Create()
        {
            Console.WriteLine("PPTX Created");
        }

        protected override void Parse()
        {
            Console.WriteLine("PPTX Parsed");
        }

        protected override void Save()
        {
            Console.WriteLine("PPTX Saved");
        }

        protected override void Validate()
        {
            Console.WriteLine("PPTX Validated");
        }

        protected override void ReValidate()
        {
            Console.WriteLine("PPTX Re-Validated");
        }
    }
    public class ReportFactory
    {
        public Report GetReport(int choice)
        {
            if(choice == 1)
            {
                return new PDF();
            }
            else if (choice == 2)
            {
                return new DOCX();
            }
            else if(choice == 3)
            {
                return new TEXT();
            }
            else
            {
                return new PPTX();
            }
        }

    }

}
