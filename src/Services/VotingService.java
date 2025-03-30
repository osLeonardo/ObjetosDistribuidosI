package Services;

import Interfaces.IVotingService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class VotingService extends UnicastRemoteObject implements IVotingService {
    private final Map<String, Integer> votes;

    public VotingService() throws RemoteException {
        votes = new HashMap<>();
    }

    @Override
    public void vote(String option) throws RemoteException {
        String normalizedOption = normalizeOption(option);
        votes.put(normalizedOption, votes.getOrDefault(normalizedOption, 0) + 1);
    }

    @Override
    public Map<String, Integer> getResults() throws RemoteException {
        if (votes.isEmpty()) {
            Map<String, Integer> defaultResult = new HashMap<>();
            defaultResult.put("No votes yet", 0);
            return defaultResult;
        }
        return votes.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int cmp = e2.getValue().compareTo(e1.getValue());
                    if (cmp == 0) {
                        return e1.getKey().compareTo(e2.getKey());
                    }
                    return cmp;
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    private String normalizeOption(String option) {
        if (option.matches("\\d+")) {
            return String.valueOf(Integer.parseInt(option));
        }
        return option.toUpperCase();
    }
}