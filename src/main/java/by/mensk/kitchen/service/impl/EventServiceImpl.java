package by.mensk.kitchen.service.impl;

import by.mensk.kitchen.model.Meal;
import by.mensk.kitchen.model.Event;
import by.mensk.kitchen.repository.EventRepository;
import by.mensk.kitchen.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private final EventRepository repository;

    public EventServiceImpl(EventRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Event> getEventsList() {
        return repository.findAll();
    }


    @Override
    public Event createEvent(String name, Integer guestNum, List<Meal> menu, Date date) {
        Event newEvent = new Event(name, date, guestNum, menu);
        repository.save(newEvent);
        return newEvent;
    }

    @Override
    public void deleteEvent(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Meal> getMenu(Integer id) {
        List<Meal> myMealOnThitIvent = null;//todo get by id
        Optional<Event> event = repository.findById(id);
        if (!event.isPresent()) {
            myMealOnThitIvent = event.get().getMenu();
        }
        return myMealOnThitIvent;
    }

    @Override
    public Event setGuestsNum(Integer eventId, Integer guestsNum) {
        return null;
    }
}
