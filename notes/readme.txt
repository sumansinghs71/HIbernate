Entity life Cycle:::

Detach: If entity is detached, It is not associated with Hibernate session.
Merge: If instance is detached from the session the merge with reattch the session.
Persist: Transitions new instances to the managed state. Next flush/commit will save in DB.
Remove: Transitions managed entity to be removed.  Next flush/commit will delete in DB.
Refresh: Reload/sync object with data from DB. Prevents Stale data.