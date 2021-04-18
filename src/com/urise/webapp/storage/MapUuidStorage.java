package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage<String> {

    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected void deleteElement(String keyUuid) {
        map.remove(keyUuid);
    }

    @Override
    protected void saveElement(Resume r, String keyUuid) {
        map.put(keyUuid, r);
    }

    @Override
    protected void updateElement(Resume r, String keyUuid) {
        map.replace(keyUuid, r);
    }

    @Override
    protected Resume getElement(String keyUuid) {
        return map.get(keyUuid);
    }

    @Override
    protected String getKeyByUuid(String uuid) {
        return uuid;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> copyElements() {
        return new ArrayList<>(map.values());
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    protected boolean isExist(String keyUuid) {
        return map.containsKey(keyUuid);
    }
}
