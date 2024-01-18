import dao.FlightDao;
import filter.AuthorizationFilter;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class AppTest {

    @Nested
    class Dao{
        @Test
        void FlightDaoFindAllResultSizeEqual0IfToEqualsNullOrFromEqualsNull(){
            var flightDao = FlightDao.getInstance();
            assertThat(flightDao.findAllWhereFromAndTo(null,"MSK").size()).isEqualTo(0);
        }
        @Test
        void ResultSizeEquals0IfFroMOrToNotInDB(){
            var flightDao = FlightDao.getInstance();
            assertAll(
                    ()-> assertThat(flightDao.findAllWhereFromAndTo("093","LLD").size()).isEqualTo(0),
                    ()->assertThat(flightDao.findAllWhereFromAndTo("MSK","dfg").size()).isEqualTo(0)
            );
        }
    }
}
