package com.codegym.task.task27.task2712.ad;

import com.codegym.task.task27.task2712.ConsoleHelper;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private List<Advertisement> playList = new LinkedList<>();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        if (storage.list().isEmpty())
            throw new NoVideoAvailableException();
        LinkedList<Advertisement> remainingVideos = new LinkedList<>(storage.list().stream().filter(video -> video.getImpressionsRemaining() > 0).collect(Collectors.toList()));
        getOptimalPlayList(remainingVideos, new LinkedList<>(), timeSeconds);
        if (playList.isEmpty())
            throw new NoVideoAvailableException();
        playList.forEach(video -> ConsoleHelper.writeMessage("Displaying " + video.getName() + "... " + video.getAmountPerImpression() + ", " + 1000L * video.getAmountPerImpression() / video.getDuration()));
        playList.forEach(Advertisement::revalidate);
    }

    private void getOptimalPlayList(List<Advertisement> remainingVideos, List<Advertisement> selectedVideos, int remainingTime) {
        List<Advertisement> newSelectedVideos = new LinkedList<>(selectedVideos);
        List<Advertisement> newRemainingVideos = new LinkedList<>(remainingVideos);
        if (newRemainingVideos.isEmpty()) {
            if (playList.isEmpty()) {
                playList = newSelectedVideos;
            } else {
                long thisPlayListSum = newSelectedVideos.stream().map(Advertisement::getAmountPerImpression).reduce(0L, Long::sum);
                long currentPlayListSum = playList.stream().map(Advertisement::getAmountPerImpression).reduce(0L, Long::sum);
                if (thisPlayListSum > currentPlayListSum) {
                    playList = newSelectedVideos;
                } else if (thisPlayListSum == currentPlayListSum) {
                    int thisPlayListDuration = newSelectedVideos.stream().map(Advertisement::getDuration).reduce(0, Integer::sum);
                    int currentPlayListDuration = playList.stream().map(Advertisement::getDuration).reduce(0, Integer::sum);
                    if (thisPlayListDuration > currentPlayListDuration || (thisPlayListDuration == currentPlayListDuration && newSelectedVideos.size() < playList.size())) {
                        playList = newSelectedVideos;
                    }
                }
            }
        } else {
            Advertisement video = newRemainingVideos.remove(0);
            getOptimalPlayList(newRemainingVideos, newSelectedVideos, remainingTime);
            if (video.getDuration() <= remainingTime) {
                newSelectedVideos.add(video);
                getOptimalPlayList(newRemainingVideos, newSelectedVideos, remainingTime - video.getDuration());
            }
        }
    }
}
