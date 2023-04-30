import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

public class IOT {
    public static void main(String[] args) {
        System.out.println(postResp("http://mgx.maigaoxun.com/kyhl-weixin-1.0//setmeal/findByCardNo.do?responseFunction=findByCardNoCallback&rfm=0.5746015969450105").bodyText());
        System.out.println(postResp("http://mgx.maigaoxun.com/kyhl-weixin-1.0//setmeal/gridto.do?responseFunction=getAgentSetMealByCategoryCallback&type=1&category=1&rfm=0.4379408693958404").bodyText());
        HttpResponse response = postResp("http://mgx.maigaoxun.com/kyhl-weixin-1.0//cardwallet/getNeedPayMoneyAndWalletBalance.do?responseFunction=getNeedPayMoneyAndWalletBalance&mealId=D5208637430285312&getMealPrice=true&allowWalletPay=true&rfm=0.8795750302655418");
        System.out.println(response.bodyText());
    }

    private static HttpResponse postResp(String url) {
        return HttpRequest
                .post(url)
                .header("Cookie", "JSESSIONID=E282C5D20DB99F296492E02DD0086052")
                .header("User-Agent","Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1")
                .send()
                .charset("utf-8");
    }

    private static HttpResponse getResp(String url) {
        return HttpRequest
                .get(url)
                .header("Cookie", "JSESSIONID=E282C5D20DB99F296492E02DD0086052")
                .header("User-Agent","Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1")
                .send()
                .charset("utf-8");
    }
}
