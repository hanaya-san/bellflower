select authorize_local_id, users_id, login_id, password
from authorize_local
where login_id = /* loginId */null
and password = /* password */null;