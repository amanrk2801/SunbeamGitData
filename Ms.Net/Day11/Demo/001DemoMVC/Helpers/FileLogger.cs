namespace _001DemoMVC.Helpers
{
    public class FileLogger
    {
        private static FileLogger _logger = new FileLogger();
        private FileLogger()
        {

        }

        public static FileLogger CurrentLogger
        {
            get
            {
                return _logger;
            }
        }
        public void Log(string message)
        {
            string path = "D:\\KaradDotNetDemos\\Data\\MVCLog.txt";
            FileStream fs = null;

            if (File.Exists(path))
            {
                fs = new FileStream(path, FileMode.Append, FileAccess.Write);
            }
            else
            {
                fs = new FileStream(path, FileMode.Create, FileAccess.Write);
            }

            StreamWriter pen = new StreamWriter(fs);

            pen.WriteLine("Logged at " +
                               DateTime.Now.ToString() + " - "
                               + message);

            pen.Close();
            fs.Close();

        }
    }
}
