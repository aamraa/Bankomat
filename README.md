A simple Library application.

The application offers the following services:
• Creating an account
• Creating books
• Raising books from a library for a specific period of time
• Print details of existing accounts

Create an account

When you create an account, you are taking the following parameters:
• Account number (int)
• Customer Name (String)
• Number of books borrowed (int)

Validation:
• You may not allow the creation of multiple accounts with the same number
• You must not allow the creation of a negative account number

Creating a book

When you create a book, you take the following parameters:
• Book number (int)
• Name of the book (String)
• Book status (boolean) - whether the book is issued or not

Validation:
• You may not allow the creation of multiple books with the same number
• You may not allow the creation of a book with a negative number

Raising a book

When you borrow a book, you are taking the following parameters:
• Account number (int)
• Book number (int)
When you issue a book, the application should increase the number of books issued for the given
The account changes you book status. Reversed is valid when a user returns a book.

Validation:
• Do not allow borrowing of a book if the account already has 3 borrowed books
• Do not allow borrowing of a book if the book has already been issued
• Do not allow borrowing of a book if the account number is invalid / there is no account in the system
• Do not allow borrowing a book if the book number is invalid / there is no book in the system
