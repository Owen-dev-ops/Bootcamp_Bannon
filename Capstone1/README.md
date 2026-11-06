# SwiftTally

A simple command-line finance log for tracking credit and debit transactions (deposits and payments).


## Features:
- Record credit transactions
- Record debit transactions
- Search transactions by:
    - Month to date, previous month, current year, or previous year
    - Vendor name
    - Custom search, filtering by any combination of start date, end date, description, vendor name, and/or amount
- Data persistence: transactions are saved in 'transactions.psv' (pipe-seperated values) in the 'resources' folder.


## Requirements:
- Java 17
- Terminal that supports ANSI colors
- Git (only needed to clone the repository)


## Setup and Running

1. Clone the repository into a folder on your computer: git clone https://github.com/Owen-dev-ops/Bootcamp_Bannon.git
2. Open folder using IntelliJ
3. Open `Main.java` and click the green arrow next to `public class Main {` to run.


## Usage:
Follow the menu and on-screen prompts to navigate the app.

**Main Menu**
```
Post Credit Transaction             : c, post-credit
Post Debit Transaction              : d, post-debit
Display Ledger (All Transactions)   : l, display-ledger
Display All Credit Transactions     : lc, display-credits
Display All Debit Transactions      : ld, display-debits
Search for a Transaction            : s, search
Exit Swift Tally                    : e, exit
```
