
import controller.command.LoginCommand;
import model.service.DAOService;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class TestLoginUtility {

    @Test
    public void testServiceCheckWithDB(){

        DAOService daoService = new DAOService();
      Assert.assertTrue(daoService.checkWithDB("daneok","login"));
    }
}
