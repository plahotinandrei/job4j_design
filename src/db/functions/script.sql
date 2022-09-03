create or replace procedure delete_data(d_id integer)
language 'plpgsql'
as $$
    BEGIN
        delete from products where id = d_id;
    END
$$;

call delete_data(7);

create or replace function delete_row_if_count_0()
returns void
language 'plpgsql'
as $$
    BEGIN
        delete from products where count = 0;
    END
$$;

select delete_row_if_count_0();
