using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace _09DemoEvents
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            Button button = new Button();
            button.Text = "Click Me";

            EventHandler pointer = new EventHandler(CallMe);

            button.Click += pointer;


            this.Controls.Add(button);

        }

        public void CallMe(object o, EventArgs e)
        {
            MessageBox.Show("My code called!");
        }
    }
}
