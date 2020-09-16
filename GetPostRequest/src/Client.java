import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Optional;
import java.util.stream.Collectors;

public class Client {

    private static final String HOST ="";
    private static final String GET_USERS_URI = "";

    private static final String TOKEN = "";

    public static void main(String[] args) throws IOException {
        Client client = new Client();

        System.out.println(client.getRawResponse(HOST + GET_USERS_URI,
                "application/x-www-form-urlencoded",
                "token=" + TOKEN).orElse("no response"));
    }

    public Optional<String> getRawResponse(String url, String contentType, String requestBody) throws MalformedURLException, IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestProperty("Content-Type", contentType);
        connection.setConnectTimeout(10000);
        connection.setRequestMethod("POST");

        connection.setDoOutput(true);

        try (OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream())){

            writer.write(requestBody);
        }

        if (connection.getResponseCode() != 200) {
            System.err.println("connection failed");
            return Optional.empty();
        }

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("utf-8")))) {

            return Optional.of(reader.lines().collect(Collectors.joining(System.lineSeparator())));
        }
    }

}
