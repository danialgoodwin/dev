# Microsoft SQL Server Management Studio Cheat Sheet
All about Microsoft SQL Server Management Studio (SSMS)

Quick notes:
- Capitalization doesn't matter for keywords or column names

## Example syntax

### Basic

    SELECT TOP 100 <column>, * FROM <table>
    SELECT <alias>.<column> FROM <table> AS <alias>
    
    UPDATE <table> SET <column> = <value> WHERE <column> = <value>
    
    DELETE FROM <table> WHERE <column> LIKE <value | '%value%'>

- For WHERE conditions, 'not-equal-to' is done with `<>`

### Advanced

    SELECT <column-list> FROM <table> as <alias-1>
        JOIN <table> as <alias-2> on <alias-1>.<column> = <alias-2>.<column> AND <alias-2>.<column> = <value>
        WHERE <alias-1>.<column> = <value>
    
    INSERT INTO <table> (<column>, <column>)
        SELECT <column>, <column> FROM <table> WHERE <column> = <value>

## Common Shortcuts

    F5                    Run query
    F5 (with selction)    Run the selected parts of the query
    control + r           Show/hide query results

## Snippets

### Search all column names
    SELECT  *
    FROM    INFORMATION_SCHEMA.COLUMNS AS c
    WHERE   c.COLUMN_NAME LIKE '%keyword%'
                AND c.TABLE_NAME NOT LIKE '%bad%'
                AND c.TABLE_NAME LIKE '%good%'
    ORDER BY c.TABLE_NAME, c.COLUMN_NAME

###

