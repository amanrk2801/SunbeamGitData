using _16ApnaAttributes;

namespace _17DemoPOCOLib
{
	[Table(TableName ="Emp")]
	public class Emp
	{
		private int _No;
		private string _Name;
		private string _Address;

        [Column(ColumnName = "Address", ColumnType = "varchar(50)")]
        public string Address
		{
			get { return _Address; }
			set { _Address = value; }
		}

        [Column(ColumnName = "Name", ColumnType = "varchar(50)")]
        public string Name
		{
			get { return _Name; }
			set { _Name = value; }
		}

		[Column(ColumnName = "No", ColumnType = "int")]
		public int No
		{
			get { return _No; }
			set { _No = value; }
		}

	}

	[Table(TableName ="Department")]
	public class Dept
	{
		private int _DeptID;

		[Column(ColumnName = "DNo", ColumnType = "int")]
		public int DeptID
		{
			get { return _DeptID; }
			set { _DeptID = value; }
		}

		private string _DeptName;

		[Column(ColumnName ="DName", ColumnType = "varchar(50)")]
		public string DeptName
		{
			get { return _DeptName; }
			set { _DeptName = value; }
		}


	}
}
