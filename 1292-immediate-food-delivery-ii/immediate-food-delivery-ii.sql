WITH first_orders AS (
    SELECT
        customer_id
        , MIN(order_date) first_date
    FROM Delivery
    GROUP BY customer_id
)

SELECT
    -- *
    ROUND(100.0 * COUNT(fo.first_date) FILTER (WHERE fo.first_date = D.customer_pref_delivery_date)/COUNT(*),2) AS immediate_percentage
FROM Delivery AS D
JOIN first_orders AS fo
    ON D.customer_id = fo.customer_id
    AND D.order_date = fo.first_date