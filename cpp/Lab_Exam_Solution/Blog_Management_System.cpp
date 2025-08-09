
#include <iostream>
#include <vector>
#include <string>

using namespace std;

// Enum for Category
enum Category {
    Travel=1,
    Music
};

// Blog class
class Blog {
    string bname;
    int bid;
    Category category;

public:
    Blog() {}
    int getBid()
    {
        return bid;
    }  
    string getBname()
    {
        return bname;
    }
    Category getCategory()
    {
        return category;
    } 

    Blog(int id, string name, Category cat) {
        this->bid = id;
        this->bname = name;
        this->category = cat;
    }

    void displayBlog() {
        cout << "Blog ID: " << bid << "\nBlog Name: " << bname <<"\nBlog Category: "<<getCategoryType()<< endl;
        cout << "-----------------\n";
    }

   
    string getCategoryType()  {
        if (category == Travel) {
            return "Travel";
        } else {
            return "Music";
        }
        
    }
};

// User class
class User {
    string uname;
    int uid;
    vector<Blog *> blogs;

public:
    User() {}

    User(int id, string name) {
        this->uid = id;
        this->uname = name;
    }

    string getName() const {
        return uname;
    }

    int getId() const {
        return uid;
    }
    vector<Blog *> &getBlogs()
    {
        return blogs;
    }

    void addBlog() {
        int blogId;
        string blogName;
        cout << "Enter Blog ID: ";
        cin >> blogId;
        cin.ignore();
        cout << "Enter Blog Name: ";
    
        getline(cin, blogName);

        int categoryChoice;
        cout << "Select Category:\n1. Travel\n2. Music\nEnter choice: ";
        cin >> categoryChoice;

        Category category;
        if (categoryChoice == 1) {
            category = Travel;
        } else if (categoryChoice == 2) {
            category = Music;
        } else {
            cout << "Invalid category choice!";
            return; // Exit if the category is invalid
        }

        Blog *newBlog = new Blog(blogId, blogName, category);
        blogs.push_back(newBlog);
        cout << "Blog Added Successfully!";
    }

    void displayBlogs() {
        if (blogs.empty()) {
            cout << "No blogs available for this user";
            return;
        }
        for (size_t i = 0; i < blogs.size(); i++) {
            blogs[i]->displayBlog();
        }
    }

    void deleteBlog(int blogId) {
        for (size_t i = 0; i < blogs.size(); i++) {
            if (blogs[i]->getBid() == blogId) {
                delete blogs[i];
                blogs.erase(blogs.begin() + i);
                cout << "Blog with ID " << blogId << " deleted successfully.";
                return;
            }
        }
        cout << "Error: Blog ID not found under your account!";
    }

    ~User () {
        for (size_t i = 0; i < blogs.size(); i++) {
            delete blogs[i];
        }
    }
};

// Function to add blogs by user
void AddBlogsByUser (vector<User*> &users) {
    if (users.empty()) {
        cout << "No users available! Please create a user first";
        return;
    }

    int userId;
    cout << "Enter User ID to add a blog: ";
    cin >> userId;

    User* userPtr = nullptr;
    for (size_t i = 0; i < users.size(); i++) {
        if (users[i]->getId() == userId) {
            userPtr = users[i];
            break;
        }
    }

    if (userPtr == nullptr) {
        cout << "User  ID not found!";
    } else {
        userPtr->addBlog();
    }
}

// Function to display blogs by user
void displayBlogsByUser (vector<User*> &users) {
    if (users.empty()) {
        cout << "No users available!";
        return;
    }

    int userId;
    cout << "Enter User ID to search blogs: ";
    cin >> userId;

    User* userPtr = nullptr;
    for (size_t i = 0; i < users.size(); i++) {
        if (users[i]->getId() == userId) {
            userPtr = users[i];
            break;
        }
    }

    if (userPtr == nullptr) {
        cout << "User  ID not found!\n";
    } else {
        userPtr->displayBlogs();
    }
}

// Function to filter blogs by category
void filterBlogsByCategory(vector<User*> &users) {
    int catChoice;
    cout << "Filter by:\n1. Travel\n2. Music\nEnter choice: ";
    cin >> catChoice;

    Category category;
    if (catChoice == 1) {
        category = Travel;
    } else if (catChoice == 2) {
        category = Music;
    } else {
        cout << "Invalid choice! Defaulting to Travel.";
        category = Travel; // Default to Travel if invalid choice
    }

    bool found = false;
    cout << "\n======= FILTERED BLOGS =======\n";
    for (int i = 0; i < users.size(); i++) {
        for (int j = 0; j < users[i]->getBlogs().size(); j++) {
            if (users[i]->getBlogs()[j]->getCategory() == category) {
                users[i]->getBlogs()[j]->displayBlog();
                found = true;
            }
        }
    }
    if (!found) {
        cout << "No blogs found under the selected category.";
    }
}

// Function to delete blogs
void deleteBlogs(vector<User*> &users) {
    if (users.empty()) {
        cout << "No users available to delete a blog.\n";
        return;
    }

    int userId;
    cout << "Enter User ID to delete a blog: ";
    cin >> userId;

    User* userPtr = nullptr;
    for (size_t i = 0; i < users.size(); i++) {
        if (users[i]->getId() == userId) {
            userPtr = users[i];
            break;
        }
    }

    if (userPtr == nullptr) {
        cout << "User  not found!\n";
    } else {
        int blogId;
        cout << "Enter Blog ID to delete: ";
        cin >> blogId;
        userPtr->deleteBlog(blogId);
    }
}

// Function to display all blogs
void displayAllBlogs(vector<User*> &users) {
    if (users.empty()) {
        cout << "No users available to display.";
        return;
    }

    cout << "\n======= ALL BLOGS =======\n";
    for (size_t i = 0; i < users.size(); i++) {
        cout << "User  ID: " << users[i]->getId() << " | Username: " << users[i]->getName() << endl;
        users[i]->displayBlogs();
    }
}

int main() {
    vector<User*> users;
    int choice;

    do {
        cout << "\n========== BLOG SYSTEM MENU ==========\n";
        cout << "1. Create User\n";
        cout << "2. Add Blog to User\n";
        cout << "3. View All Blogs\n";
        cout << "4. Find Blogs by User ID\n";
        cout << "5. Filter Blogs by Category\n";
        cout << "6. Delete Blog\n";
        cout << "7. Exit\n";
        cout << "======================================\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1: {
                int id;
                string name;
                cout << "Enter User ID: ";
                cin >> id;
                cout << "Enter Username: ";
                cin >> name;
                users.push_back(new User(id, name));
                cout << "User  Created Successfully!\n";
                break;
            }
            case 2: {
                AddBlogsByUser (users);
                break;
            }
            case 3: {
                displayAllBlogs(users);
                break;
            }
            case 4: {
                displayBlogsByUser (users);
                break;
            }
            case 5: {
                filterBlogsByCategory(users);
                break;
            }
            case 6: {
                deleteBlogs(users);
                break;
            }
            case 7: {
                cout << "Exiting program...\n";
                // Clean up dynamically allocated memory
                for (size_t i = 0; i < users.size(); i++) {
                    delete users[i];
                }
                return 0;
            }
            default:
                cout << "Invalid choice! Please try again.\n";
        }
    } while (choice != 7);

    return 0;
}