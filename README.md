# Mini AI Chat Backend

A focused 7-day backend learning project built with **Spring Boot + Kotlin + Gradle**.

This project is intentionally minimal and interview-oriented.  
The goal is to internalize backend fundamentals by building one coherent system instead of scattered tutorials.

---

## 🎯 Project Goals

By the end of this project, I should be able to:

- Explain how a Spring Boot backend is structured
- Design clean REST APIs with correct HTTP semantics
- Model data using JPA/Hibernate
- Reason about transactions, indexing, and data consistency
- Use Redis effectively with cache-aside pattern
- Integrate a slow/unreliable external system (LLM)
- Handle concurrency and race conditions
- Explain architectural trade-offs clearly in interviews

---

## 🧱 Tech Stack

- Spring Boot
- Kotlin
- Gradle
- PostgreSQL (or H2 for development)
- Redis
- REST APIs only (no frontend)

---

## 📅 7-Day Roadmap & Checklist

---

## Day 1 — Project Skeleton & Spring Boot Mental Model

### Goal
Understand Spring Boot structure and request flow  
(Controller → Service → Repository)

### Tasks
- [x] Initialize Spring Boot project (Kotlin + Gradle)
- [x] Define base packages:
    - [x] `api`
    - [x] `service`
    - [x] `repository`
    - [x] `domain`
- [x] Implement `GET /health`
- [x] Create a stub `ChatController`
- [x] Run application successfully

### Must-Have
- [x] Application starts without errors
- [x] At least one REST endpoint returns JSON
- [x] Clear separation between controller and service

---

## Day 2 — REST API Design & HTTP Semantics

### Goal
Design correct REST APIs and understand HTTP behavior

### Tasks
- [ ] Design endpoints:
    - [ ] `POST /chats`
    - [ ] `GET /chats/{chatId}`
    - [ ] `POST /chats/{chatId}/messages`
- [ ] Create request/response DTOs
- [ ] Apply validation annotations
- [ ] Return correct HTTP status codes
- [ ] Handle 400 / 404 errors properly

### Must-Have
- [ ] No domain entities exposed directly
- [ ] Validation errors return meaningful responses

---

## Day 3 — JPA, Hibernate & Data Modeling

### Goal
Understand ORM fundamentals and entity relationships

### Tasks
- [ ] Create `Chat` entity
- [ ] Create `Message` entity
- [ ] Define `@OneToMany` relationship
- [ ] Configure H2 or PostgreSQL
- [ ] Create repositories using Spring Data JPA
- [ ] Persist and fetch chats with messages

### Must-Have
- [ ] Messages are stored and retrieved from DB
- [ ] Proper primary and foreign keys exist

---

## Day 4 — Transactions, Indexing & Data Consistency

### Goal
Reason about atomicity, failures, and performance

### Tasks
- [ ] Add `@Transactional` to message creation
- [ ] Simulate failure inside a transaction
- [ ] Verify rollback behavior
- [ ] Add DB indexes:
    - [ ] `chat_id`
    - [ ] `created_at`
- [ ] Identify where indexes are used

### Must-Have
- [ ] Message creation is atomic
- [ ] Clear understanding of rollback behavior

---

## Day 5 — Redis Caching (Cache-Aside Pattern)

### Goal
Use caching correctly and safely

### Tasks
- [ ] Integrate Redis
- [ ] Cache recent messages per chat
- [ ] Implement cache-aside pattern:
    - [ ] Read from cache
    - [ ] Fallback to DB
    - [ ] Populate cache
- [ ] Add TTL
- [ ] Invalidate cache on new message

### Must-Have
- [ ] Redis is actually used
- [ ] Cache invalidation works correctly

---

## Day 6 — LLM Integration, Latency & Concurrency

### Goal
Integrate a slow external dependency safely

### Tasks
- [ ] Implement LLM client (real or mock)
- [ ] Call LLM using coroutines
- [ ] Add timeout
- [ ] Add retry logic
- [ ] Add fallback response
- [ ] Prevent duplicate AI responses (race condition)

### Must-Have
- [ ] Non-blocking LLM call
- [ ] Graceful failure handling

---

## Day 7 — Observability, Trade-offs & Interview Readiness

### Goal
Explain the system clearly and confidently

### Tasks
- [ ] Add structured logging
- [ ] Log request ID and chat ID
- [ ] Log LLM latency
- [ ] Add basic metrics (count, timing)
- [ ] Write architecture & trade-offs section
- [ ] Identify system limitations

### Must-Have
- [ ] Logs are useful for debugging
- [ ] Clear explanation of architectural decisions

---

## 🧠 Architecture & Trade-Offs

### Why REST?
- Simpler mental model
- Easy to reason about in interviews
- Clear HTTP semantics

### Why Redis?
- Reduce DB load for hot data
- Acceptable staleness for chat history
- Demonstrates cache-aside pattern

### Known Limitations
- No authentication
- No streaming responses
- No horizontal scaling
- No message ordering guarantees across instances

---

## ✅ Completion Criteria

This project is **complete** when:
- [ ] All Must-Have items are checked
- [ ] You can explain every major decision out loud
- [ ] You can answer “why” for each technology choice

---

