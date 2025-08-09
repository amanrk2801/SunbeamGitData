namespace _05DemoOOP
{
    #region Logger, Database using Base + Events, Delegates + FileIO
    //public class Program
    //{
    //    static void Main(string[] args)
    //    {
    //        Console.WriteLine("1: SQL , 2: MYSQL");
    //        int choice = Convert.ToInt32(Console.ReadLine());

    //        DBFactory dBFactory = new DBFactory();
    //        Database database = dBFactory.GetDatabase(choice);

    //        MyDelegate pointer = new MyDelegate(Logger.CurrentLogger.Log);

    //        database.OnInsert += pointer;
    //        database.OnUpdate += pointer;
    //        database.OnDelete += pointer;

    //        Console.WriteLine("1: Insert, 2: Update, 3: Delete");

    //        int dbChoice = Convert.ToInt32(Console.ReadLine());
    //        switch (dbChoice)
    //        {
    //            case 1:
    //                database.Insert();
    //                break;
    //            case 2:
    //                database.Update();
    //                break;
    //            case 3:
    //                database.Delete();
    //                break;
    //            default:
    //                Console.WriteLine("Invalid choice");
    //                break;
    //        }

    //        Console.ReadLine();

    //    }

    //    public static void MylogMethod1(string message)
    //    {
    //        Console.WriteLine("This is email logger .. logging message: " + message);
    //    }

    //    public static void MylogMethod2(string message)
    //    {
    //        Console.WriteLine("This is SMS logger .. logging message: " + message);
    //    }

    //    public static void MylogMethod3(string message)
    //    {
    //        Console.WriteLine("This is WhatsApp logger .. logging message: " + message);
    //    }
    //}

    //public delegate void MyDelegate(string message);
    //public abstract class Database
    //{
    //    protected abstract void DoInsert();
    //    protected abstract void DoUpdate();
    //    protected abstract void DoDelete();
    //    protected abstract string GetDataBaseName();

    //    public event MyDelegate OnInsert;
    //    public event MyDelegate OnUpdate;
    //    public event MyDelegate OnDelete;

    //    public void Insert()
    //    {
    //        DoInsert();
    //        OnInsert(GetDataBaseName() + " Insert Done!");
    //    }

    //    public void Update()
    //    {
    //        DoUpdate();
    //        OnUpdate(GetDataBaseName() + " Update Done!");
    //    }


    //    public void Delete()
    //    {
    //        DoDelete();
    //        OnDelete(GetDataBaseName() + " Delete Done!");
    //    }
    //}
    //public class SqlServer : Database
    //{
    //    protected override string GetDataBaseName()
    //    {
    //        return "SQL Server";
    //    }
    //    protected override void DoInsert()
    //    {
    //        Console.WriteLine("Insert done in SQL Server");
    //    }

    //    protected override void DoUpdate()
    //    {
    //        Console.WriteLine("Update done in SQL Server");
    //    }

    //    protected override void DoDelete()
    //    {
    //        Console.WriteLine("Delete done in SQL Server");
    //    }
    //}
    //public class MYSQL : Database
    //{
    //    protected override string GetDataBaseName()
    //    {
    //        return "MYSQL";
    //    }
    //    protected override void DoInsert()
    //    {
    //        Console.WriteLine("Insert done in MYSQL Server");
    //    }

    //    protected override void DoUpdate()
    //    {
    //        Console.WriteLine("Update done in MYSQL Server");
    //    }

    //    protected override void DoDelete()
    //    {
    //        Console.WriteLine("Delete done in MYSQL Server");
    //    }
    //}
    //public class DBFactory
    //{
    //    public Database GetDatabase(int choice)
    //    {
    //        if (choice == 1)
    //        {
    //            return new SqlServer();
    //        }
    //        else
    //        {
    //            return new MYSQL();
    //        }
    //    }
    //}
    //public class Logger
    //{
    //    private static Logger _logger = new Logger();
    //    private Logger()
    //    {
    //        Console.WriteLine("New Logger Object Created...");
    //    }

    //    public static Logger CurrentLogger
    //    {
    //        get
    //        {
    //            return _logger;
    //        }
    //    }
    //    public void Log(string message)
    //    {
    //        string path = "D:\\KaradDotNetDemos\\Data\\Log.txt";
    //        FileStream fs = null;

    //        if (File.Exists(path))
    //        {
    //            fs = new FileStream(path, FileMode.Append, FileAccess.Write);
    //        }
    //        else
    //        {
    //            fs = new FileStream(path, FileMode.Create, FileAccess.Write);
    //        }

    //        StreamWriter pen = new StreamWriter(fs);

    //        pen.WriteLine("Logged at " +
    //                           DateTime.Now.ToString() + " - "
    //                           + message);

    //        pen.Close();
    //        fs.Close();

    //    }
    //}
    #endregion

    #region Logger, Database using Base + Events, Delegates
    //public class Program
    //{
    //    static void Main(string[] args)
    //    {
    //        Console.WriteLine("1: SQL , 2: MYSQL");
    //        int choice = Convert.ToInt32(Console.ReadLine());

    //        DBFactory dBFactory = new DBFactory();
    //        Database database = dBFactory.GetDatabase(choice);

    //        //MyDelegate pointer = new MyDelegate(MylogMethod1);
    //        MyDelegate pointer = new MyDelegate(MylogMethod2);

    //        database.OnInsert += pointer;
    //        database.OnUpdate += pointer;
    //        database.OnDelete += pointer;

    //        Console.WriteLine(  "1: Insert, 2: Update, 3: Delete");

    //        int dbChoice = Convert.ToInt32(Console.ReadLine());
    //        switch (dbChoice)
    //        {
    //            case 1:
    //                database.Insert();
    //                break;
    //            case 2:
    //                database.Update();
    //                break;
    //            case 3:
    //                database.Delete();
    //                break;
    //            default:
    //                Console.WriteLine("Invalid choice");
    //                break;
    //        }

    //        Console.ReadLine();

    //    }

    //    public static void MylogMethod1(string message)
    //    {
    //        Console.WriteLine("This is email logger .. logging message: " + message);
    //    }

    //    public static void MylogMethod2(string message)
    //    {
    //        Console.WriteLine("This is SMS logger .. logging message: " + message);
    //    }

    //    public static void MylogMethod3(string message)
    //    {
    //        Console.WriteLine("This is WhatsApp logger .. logging message: " + message);
    //    }
    //}

    //public delegate void MyDelegate(string message);
    //public abstract class Database
    //{
    //    protected abstract void DoInsert();
    //    protected abstract void DoUpdate();
    //    protected abstract void DoDelete();
    //    protected abstract string GetDataBaseName();

    //    public event MyDelegate OnInsert;
    //    public event MyDelegate OnUpdate;
    //    public event MyDelegate OnDelete; 

    //    public void Insert()
    //    {
    //        DoInsert();
    //        OnInsert(GetDataBaseName() + " Insert Done!");
    //    }

    //    public void Update()
    //    {
    //        DoUpdate();
    //        OnUpdate(GetDataBaseName() + " Update Done!");
    //    }


    //    public void Delete()
    //    {
    //        DoDelete();
    //        OnDelete(GetDataBaseName() + " Delete Done!");
    //    }
    //}
    //public class SqlServer : Database
    //{
    //    protected override string GetDataBaseName()
    //    {
    //        return "SQL Server";
    //    }
    //    protected override void DoInsert()
    //    {
    //        Console.WriteLine("Insert done in SQL Server");
    //    }

    //    protected override void DoUpdate()
    //    {
    //        Console.WriteLine("Update done in SQL Server");
    //    }

    //    protected override void DoDelete()
    //    {
    //        Console.WriteLine("Delete done in SQL Server");
    //    }
    //}
    //public class MYSQL : Database
    //{
    //    protected override string GetDataBaseName()
    //    {
    //        return "MYSQL";
    //    }
    //    protected override void DoInsert()
    //    {
    //        Console.WriteLine("Insert done in MYSQL Server");
    //    }

    //    protected override void DoUpdate()
    //    {
    //        Console.WriteLine("Update done in MYSQL Server");
    //    }

    //    protected override void DoDelete()
    //    {
    //        Console.WriteLine("Delete done in MYSQL Server");
    //    }
    //}
    //public class DBFactory
    //{
    //    public Database GetDatabase(int choice)
    //    {
    //        if (choice == 1)
    //        {
    //            return new SqlServer();
    //        }
    //        else
    //        {
    //            return new MYSQL();
    //        }
    //    }
    //}
    //public class Logger
    //{
    //    private static Logger _logger = new Logger();
    //    private Logger()
    //    {
    //        Console.WriteLine("New Logger Object Created...");
    //    }

    //    public static Logger CurrentLogger
    //    {
    //        get
    //        {
    //            return _logger;
    //        }
    //    }
    //    public void Log(string message)
    //    {
    //        Console.WriteLine("Logged at " +
    //                           DateTime.Now.ToString() + " - "
    //                           + message);
    //    }
    //}
    #endregion

    #region Logger, Database using Base + Delegates
    //public class Program
    //{
    //    static void Main(string[] args)
    //    {
    //        //Logger.CurrentLogger.Log("My Message 1");
    //        //Logger.CurrentLogger.Log("My Message 2");
    //        //Logger.CurrentLogger.Log("My Message 3");

    //        Console.WriteLine("1: SQL , 2: MYSQL");
    //        int choice = Convert.ToInt32(Console.ReadLine());

    //        DBFactory dBFactory = new DBFactory();
    //        Database database = dBFactory.GetDatabase(choice);

    //        //MyDelegate pointer = new MyDelegate(MylogMethod1);
    //        //MyDelegate pointer = new MyDelegate(MylogMethod2);
    //        //MyDelegate pointer = new MyDelegate(MylogMethod3);
    //        MyDelegate pointer = 
    //            new MyDelegate(Logger.CurrentLogger.Log);

    //        database.Update(pointer);

    //        Console.ReadLine();

    //    }

    //    public static void MylogMethod1(string message)
    //    {
    //        Console.WriteLine("This is email logger .. logging message: " + message);
    //    }

    //    public static void MylogMethod2(string message)
    //    {
    //        Console.WriteLine("This is SMS logger .. logging message: " + message);
    //    }

    //    public static void MylogMethod3(string message)
    //    {
    //        Console.WriteLine("This is WhatsApp logger .. logging message: " + message);
    //    }
    //}

    //public delegate void MyDelegate(string message);
    //public abstract class Database
    //{
    //    protected abstract void DoInsert();
    //    protected abstract void DoUpdate();
    //    protected abstract void DoDelete();
    //    protected abstract string GetDataBaseName();

    //    public void Insert(MyDelegate pointer)
    //    {
    //        DoInsert();
    //        pointer(GetDataBaseName() + " Insert Done!");
    //        //Logger.CurrentLogger.Log(GetDataBaseName() + " Insert Done!");
    //    }

    //    public void Update(MyDelegate pointer)
    //    {
    //        DoUpdate();
    //        pointer(GetDataBaseName() + " Update Done!");
    //        //Logger.CurrentLogger.Log(GetDataBaseName() + " Update Done!");
    //    }


    //    public void Delete(MyDelegate pointer)
    //    {
    //        DoDelete();
    //        pointer(GetDataBaseName() + " Delete Done!");
    //        //Logger.CurrentLogger.Log(GetDataBaseName() + " Delete Done!");
    //    }
    //}
    //public class SqlServer : Database
    //{
    //    protected override string GetDataBaseName()
    //    {
    //        return "SQL Server";
    //    }
    //    protected override void DoInsert()
    //    {
    //        Console.WriteLine("Insert done in SQL Server");
    //    }

    //    protected override void DoUpdate()
    //    {
    //        Console.WriteLine("Update done in SQL Server");
    //    }

    //    protected override void DoDelete()
    //    {
    //        Console.WriteLine("Delete done in SQL Server");
    //    }
    //}
    //public class MYSQL : Database
    //{
    //    protected override string GetDataBaseName()
    //    {
    //        return "MYSQL";
    //    }
    //    protected override void DoInsert()
    //    {
    //        Console.WriteLine("Insert done in MYSQL Server");
    //    }

    //    protected override void DoUpdate()
    //    {
    //        Console.WriteLine("Update done in MYSQL Server");
    //    }

    //    protected override void DoDelete()
    //    {
    //        Console.WriteLine("Delete done in MYSQL Server");
    //    }
    //}
    //public class DBFactory
    //{
    //    public Database GetDatabase(int choice)
    //    {
    //        if (choice == 1)
    //        {
    //            return new SqlServer();
    //        }
    //        else
    //        {
    //            return new MYSQL();
    //        }
    //    }
    //}
    //public class Logger
    //{
    //    private static Logger _logger = new Logger();
    //    private Logger()
    //    {
    //        Console.WriteLine("New Logger Object Created...");
    //    }

    //    public static Logger CurrentLogger
    //    {
    //        get
    //        {
    //            return _logger;
    //        }
    //    }
    //    public void Log(string message)
    //    {
    //        Console.WriteLine("Logged at " +
    //                           DateTime.Now.ToString() + " - "
    //                           + message);
    //    }
    //}
    #endregion

    #region Logger, Database using Base

    //public class Program
    //{
    //    static void Main(string[] args)
    //    {
    //        //Logger.CurrentLogger.Log("My Message 1");
    //        //Logger.CurrentLogger.Log("My Message 2");
    //        //Logger.CurrentLogger.Log("My Message 3");

    //        Console.WriteLine("1: SQL , 2: MYSQL");
    //        int choice = Convert.ToInt32(Console.ReadLine());

    //        DBFactory dBFactory = new DBFactory();
    //        Database database = dBFactory.GetDatabase(choice);

    //        database.Update();

    //        Console.ReadLine();

    //    }
    //}

    //public abstract class Database
    //{
    //    protected abstract void DoInsert();
    //    protected abstract void DoUpdate();
    //    protected abstract void DoDelete();
    //    protected abstract string GetDataBaseName();

    //    public void Insert()
    //    {
    //        DoInsert();
    //        Logger.CurrentLogger.Log(GetDataBaseName() + " Insert Done!");
    //    }

    //    public void Update()
    //    {
    //        DoUpdate();
    //        Logger.CurrentLogger.Log(GetDataBaseName() + " Update Done!");
    //    }


    //    public void Delete()
    //    {
    //        DoDelete();
    //        Logger.CurrentLogger.Log(GetDataBaseName() + " Delete Done!");
    //    }
    //}

    //public class SqlServer : Database
    //{
    //    protected override string GetDataBaseName()
    //    {
    //        return "SQL Server";
    //    }
    //    protected override void DoInsert()
    //    {
    //        Console.WriteLine("Insert done in SQL Server");
    //    }

    //    protected override void DoUpdate()
    //    {
    //        Console.WriteLine("Update done in SQL Server");
    //    }

    //    protected override void DoDelete()
    //    {
    //        Console.WriteLine("Delete done in SQL Server");
    //    }
    //}

    //public class MYSQL : Database
    //{
    //    protected override string GetDataBaseName()
    //    {
    //        return "MYSQL";
    //    }
    //    protected override void DoInsert()
    //    {
    //        Console.WriteLine("Insert done in MYSQL Server");
    //    }

    //    protected override void DoUpdate()
    //    {
    //        Console.WriteLine("Update done in MYSQL Server");
    //    }

    //    protected override void DoDelete()
    //    {
    //        Console.WriteLine("Delete done in MYSQL Server");
    //    }
    //}

    //public class DBFactory
    //{
    //    public Database GetDatabase(int choice)
    //    {
    //        if (choice == 1)
    //        {
    //            return new SqlServer();
    //        }
    //        else
    //        {
    //            return new MYSQL();
    //        }
    //    }
    //}

    //public class Logger
    //{
    //    private static Logger _logger = new Logger();
    //    private Logger()
    //    {
    //        Console.WriteLine("New Logger Object Created...");
    //    }

    //    public static Logger CurrentLogger
    //    {
    //        get
    //        {
    //            return _logger;
    //        }
    //    }
    //    public void Log(string message)
    //    {
    //        Console.WriteLine("Logged at " +
    //                           DateTime.Now.ToString() + " - "
    //                           + message);
    //    }
    //}

    #endregion

    #region Logger, Database using Interface  
    //public class Program
    //{
    //    static void Main(string[] args)
    //    {
    //        //Logger.CurrentLogger.Log("My Message 1");
    //        //Logger.CurrentLogger.Log("My Message 2");
    //        //Logger.CurrentLogger.Log("My Message 3");

    //        Console.WriteLine("1: SQL , 2: MYSQL" );
    //        int choice = Convert.ToInt32( Console.ReadLine() );

    //        DBFactory dBFactory = new DBFactory();
    //        IDatabase database = dBFactory.GetDatabase(choice);

    //        database.Update();

    //        Console.ReadLine();

    //    }
    //}

    //public interface IDatabase
    //{
    //    void Insert();
    //    void Update();
    //    void Delete();
    //}

    //public class SqlServer : IDatabase
    //{
    //    public void Insert()
    //    {
    //        Console.WriteLine("Insert done in SQL Server");
    //        Logger.CurrentLogger.Log("SQL Insert Done!");
    //    }

    //    public void Update()
    //    {
    //        Console.WriteLine("Update done in SQL Server");
    //        Logger.CurrentLogger.Log("SQL Update Done!");
    //    }

    //    public void Delete()
    //    {
    //        Console.WriteLine("Delete done in SQL Server");
    //        Logger.CurrentLogger.Log("SQL Delete Done!");
    //    }
    //}

    //public class MYSQL: IDatabase
    //{
    //    public void Insert()
    //    {
    //        Console.WriteLine("Insert done in MYSQL Server");
    //        Logger.CurrentLogger.Log("MYSQL Insert Done!");
    //    }

    //    public void Update()
    //    {
    //        Console.WriteLine("Update done in MYSQL Server");
    //        Logger.CurrentLogger.Log("MYSQL Update Done!");
    //    }

    //    public void Delete()
    //    {
    //        Console.WriteLine("Delete done in MYSQL Server");
    //        Logger.CurrentLogger.Log("MYSQL Delete Done!");
    //    }
    //}

    //public class DBFactory
    //{
    //    public IDatabase GetDatabase(int choice)
    //    {
    //        if (choice == 1)
    //        {
    //            return new SqlServer();
    //        }
    //        else
    //        {
    //            return new MYSQL();
    //        }
    //    }
    //}

    //public class Logger
    //{
    //    private static Logger _logger = new Logger();
    //    private Logger()
    //    {
    //        Console.WriteLine("New Logger Object Created...");
    //    }

    //    public static Logger CurrentLogger 
    //    {
    //        get 
    //        { 
    //            return _logger; 
    //        } 
    //    }
    //    public void Log(string message) 
    //    {
    //        Console.WriteLine("Logged at " + 
    //                           DateTime.Now.ToString() + " - " 
    //                           + message);
    //    }
    //} 
    #endregion
}
