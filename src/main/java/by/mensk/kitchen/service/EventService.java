package by.mensk.kitchen.service;

import by.mensk.kitchen.model.Event;
import by.mensk.kitchen.model.Meal;

import java.util.Date;
import java.util.List;

public interface EventService {
     List<Event> getEventsList ();
     Event createEvent(String name, Integer guestNum, List<Meal> menu, Date date);
     void deleteEvent(Integer eventId);


     List<Meal> getMenu(Integer eventId);

     Event setGuestsNum(Integer eventId, Integer guestsNum);

}
