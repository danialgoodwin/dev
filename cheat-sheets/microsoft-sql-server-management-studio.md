# Microsoft SQL Server Management Studio Cheat Sheet
All about Microsoft SQL Server Management Studio (SSMS)

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

