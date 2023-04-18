select player_id, TO_CHAR(MIN(event_date), 'yyyy-mm-dd') as first_login
from activity
group by player_id

