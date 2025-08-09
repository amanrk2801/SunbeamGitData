import os
import sys
import PyPDF2

def pdf_to_text(pdf_file, output_file=None):
    """
    Convert a PDF file to a text file
    
    Args:
        pdf_file (str): Path to the PDF file
        output_file (str, optional): Path to the output text file.
                                    If None, uses the same name as PDF but with .txt extension
    
    Returns:
        str: Path to the output text file
    """
    if not output_file:
        output_file = os.path.splitext(pdf_file)[0] + '.txt'
    
    try:
        # Open the PDF file
        with open(pdf_file, 'rb') as file:
            # Create a PDF reader object
            pdf_reader = PyPDF2.PdfReader(file)
            
            # Get the number of pages in the PDF file
            num_pages = len(pdf_reader.pages)
            
            # Extract text from each page
            with open(output_file, 'w', encoding='utf-8') as out_file:
                for page_num in range(num_pages):
                    page = pdf_reader.pages[page_num]
                    text = page.extract_text()
                    out_file.write(text)
                    # Add a page separator if not the last page
                    if page_num < num_pages - 1:
                        out_file.write('\n\n--- Page {} ---\n\n'.format(page_num + 2))
            
            print(f"Successfully converted {pdf_file} to {output_file}")
            return output_file
            
    except Exception as e:
        print(f"Error converting {pdf_file} to text: {e}")
        return None

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Usage: python pdf_to_text.py <pdf_file> [output_file]")
        sys.exit(1)
    
    pdf_file = sys.argv[1]
    output_file = sys.argv[2] if len(sys.argv) > 2 else None
    
    pdf_to_text(pdf_file, output_file)
