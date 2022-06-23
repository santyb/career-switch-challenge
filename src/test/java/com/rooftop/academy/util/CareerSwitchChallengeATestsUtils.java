package com.rooftop.academy.util;

import com.rooftop.academy.dto.BlocksDTO;
import com.rooftop.academy.dto.CheckApiResponse;

import java.util.ArrayList;
import java.util.List;

public class CareerSwitchChallengeATestsUtils {

    private CareerSwitchChallengeATestsUtils() {
    }

    public static CheckApiResponse checkResponse() {
        CheckApiResponse checkApiResponse = new CheckApiResponse();
        checkApiResponse.setMessage(true);
        return checkApiResponse;
    }

    public static BlocksDTO blocksRequestMock() {
        BlocksDTO blocksDTO = new BlocksDTO();
        List<String> blocksList = new ArrayList<>();
        blocksList.add("1aqNBrZus5xPXYSy0uBseSqm0nKFua7IJ46vLAHW1XiHCFopodFCvJ2QWN7GnomCWaEgsHLysu5biqDGooWWHrnWGK1abwAOyx2X");
        blocksList.add("zNADz2LiWoV51L9Kzn8kglI5UN6MGp5jHr1OAU9vBHmsEWPB1W5i0iwvKcn7J7iNrKDYQ8KqYmvWkCElaX5eRRbZi2d1P05P18pZ");
        blocksList.add("Agjd4iqy68SIfCr51zB8eytxjgpikfuCmlFKicSlopTzAmtOPNRnRrUxXQF0qmEjFqDUELqrNl8yRCo3MqvThswm2yeZdrilDTPA");
        blocksList.add("TulSl8hfhB3WPc9RmcbJFeh1q93Us6LEz4WOYYvXGzMiYUtzDuutjYVP5md2fhSbvJi9L3ukeJBPLhwb51xGRO37s9zmrYYZJjJF");
        blocksList.add("q9lJ6ZSiJXitfjoB7TT4IyPxiW2HNbMbqH0flTuuDEHSwRKZRTjjxawWrFVmOPMMjPhnmqQfRgMCnm9slFFUTTir0rONbL3Ck6Ol");
        blocksList.add("Z2vaSptUEpDOA457BnNHCHU2zQ0gTsgS9SeqKtHeuIdkyl4thbhPsJ2U6aBGxMKqnqZ3HtWKjSCmi1oCruYgSXdOStJfIbNbCfod");
        blocksList.add("rGFtjgcKo27KEwh6qM0LlTTW9cslqtkLV42rxsogDwrb3oAUTRBQyzFYb7zwsFZXJ4kjnud6y4gvQyLHRPNHIqSdrmGhQRHk0077");
        blocksList.add("qgVWcyTy3zH2B2jcmMi2cVuKVmxV6YtloSHdNCd9jmlf1UxEmSJTYcQHAZQkK04ehqhJCI8BF8mN4hlRkqXCcxXoYv4AWBewIJCD");
        blocksList.add("9jWixcI3gUMDs4vjXT9uJ5d8TZX1w6BGy5Xwu3pIamkshZ3KC0poQByQlHM5oHjcTeqXwXZlpftxW2PJ9fkPm0svIlXuvjh84cib");

        blocksDTO.setBlocks(blocksList);

        return blocksDTO;
    }
}
