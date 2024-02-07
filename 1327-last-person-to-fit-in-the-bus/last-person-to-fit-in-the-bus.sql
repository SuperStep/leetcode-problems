  select
        person_name
    from (
        select
            person_name, 
            turn,
            sum(weight) over (order by turn) as total_weight
        from Queue
        order by turn desc
    ) a
    where
        total_weight <= 1000
    limit 1