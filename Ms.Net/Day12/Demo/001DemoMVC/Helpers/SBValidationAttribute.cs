using System.ComponentModel.DataAnnotations;

namespace _001DemoMVC.Helpers
{
    public class SBValidationAttribute: ValidationAttribute
    {
        public override bool IsValid(object? value)
        {
            if(value != null     && value.ToString() == "1234")
            {
                return false;
            }
            else
            {
                return true;
            }
        }
    }
}
