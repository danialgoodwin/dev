# Cron

On Ubuntu, you can use `crontab`.

    // Show current cron jobs
    crontab -l

    // Edit cron jobs (active once saved)
    crontab -e

The format for cron jobs is `* * * * * * CMD`, where the asterisks are minute (0-59), hour (0-23), day-of-month (0-31), month-of-year (1-12), day-of-week(1-7, where 1=Monday), year (YYYY). If you don't care about the value for a field, then leave as asterisks. More info: [Cron Format](http://www.nncron.ru/help/EN/working/cron-format.htm)

To have multiple times for a field, use a comma, no space. Ex: 0,30 for job at 0 minutes and 30 minutes.

To have a range, use a hyphen. Ex: `1-5` for weekdays.

To have a repeating interval use a forward slash, then the time interval. Ex: `/1` for every minute or every hour depending on field.

Instead of specifying exact date-time, you can also use keywords like `@reboot` to have a command run each time the machine is booted. The format would be `@keyword CMD`.

Warnings and errors from root crontab by default will be "mailed" to ""/var/mail/root".


## Examples

    # The format
    # minute  hour  day-of-month  month  day-of-week  command
    
    # Run a command once a minute for all time.
    /1 * * * * command.sh
    
    # Create a new file every Monday-Friday
    * * * * 1-5 touch my-new-file.txt



## Further Resources
- [Wikipedia: Cron](https://en.wikipedia.org/wiki/Cron)
