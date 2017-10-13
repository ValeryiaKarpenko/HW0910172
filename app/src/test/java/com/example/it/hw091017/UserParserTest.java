package com.example.it.hw091017;



import com.example.it.hw091017.Http.IHttpClient;
import com.example.it.hw091017.Mock.Mocks;
import com.example.it.hw091017.json.IUser;
import com.example.it.hw091017.json.IUsersList;
import com.example.it.hw091017.json.UserParserFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(
        constants = BuildConfig.class,
        sdk = 21
)
public class UserParserTest {


    private static final String SOURCE = "{\n" +
            "  \"_id\" : \"59dbe02684a66bbe143b20d1\",\n" +
            "  \"age\" :  23, \n" +
            "  \"name\" : \"Shelia Chang\",\n" +
            "  \"registered\" :  \"1507582371121\" \n" +
            "}";


    private static final int AGE = 23;
    private static final String NAME = "Shelia Chang";
    private static final String ID = "59dbe02684a66bbe143b20d1";
    private static final String REGISTERED = "09 Oct 2017, 10:52:51";

    private IHttpClient mHttpClient;

    @Before
    public void setUp() {
        mHttpClient = mock(IHttpClient.class);
    }


    @Test
    public void parseJSONObject() throws Exception {
        final UserParserFactory userParserFactory = new UserParserFactory();
        final IUser user = userParserFactory.createParser(SOURCE).parse();

        assertEquals(ID, user.getId());
        assertEquals(NAME, user.getName());
        assertEquals(REGISTERED, user.getRegistered());
        assertEquals(AGE, user.getAge());
    }

    @Test
    public void parseGSONObject() throws Exception {
        final UserParserFactory userParserFactory = new UserParserFactory();
        final IUser user = userParserFactory.createGsonParser(SOURCE).parse();

        assertEquals(ID, user.getId());
        assertEquals(NAME, user.getName());
        assertEquals(REGISTERED, user.getRegistered());
        assertEquals(AGE, user.getAge());
    }



    @Test
    public void parseUserListFromResource() throws Exception {

         final InputStream mInputStream = Mocks.stream("generated.json");
         when(mHttpClient.request(Matchers.anyString())).thenReturn(mInputStream);
         InputStream response = mHttpClient.request("http://myBackend/getUsersList");
         final UserParserFactory usersListParserFactory = new UserParserFactory();
         final IUsersList users = usersListParserFactory.createGsonListParser(response).parse();
         final List<IUser> usersList = users.getUsersList();
         assertEquals(usersList.get(0).getId(), ID);
         assertEquals(usersList.get(0).getName(),NAME);
         assertEquals(usersList.get(0).getAge(),AGE);
         assertEquals(usersList.get(0).getRegistered(),REGISTERED);
    }

    @Test
    public void parseUserListJsonFromResource() throws Exception {

        final InputStream mInputStream = Mocks.stream("generated.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mInputStream);
        InputStream response = mHttpClient.request("http://myBackend/getUsersList");
        final UserParserFactory usersListParserFactory = new UserParserFactory();
        final IUsersList users = usersListParserFactory.createJsonListParser(response).parse();
        final List<IUser> usersList = users.getUsersList();
        assertEquals(usersList.get(0).getId(), ID);
        assertEquals(usersList.get(0).getName(),NAME);
        assertEquals(usersList.get(0).getAge(),AGE);
        assertEquals(usersList.get(0).getRegistered(),REGISTERED);
    }
}


