# Idgie-ing Welcome Card & Profile Header Redesign

A personalized, warm welcome experience replacing the generic "Seeker Profile" header with a featured greeting card from Idgie-ing, created by KaliMike to guide decision-making during I Ching divination.

## User Review & Critical Decisions

> [!IMPORTANT]
> The greeting message is structured inside a dedicated Welcome Card prominently placed at the top of the profile screen, keeping the top bar clean and readable while honoring the exact requested greeting text.

- **Confirmed Greeting Text**:
  > *"Hi ! I am Idgie-ing, I was created by KaliMike to help you make a decision when you most need it! Just think about the question you have and hold that thought when you throw the dice."*
- **Presentation Mode**: Dedicated, styled **Welcome Card** located immediately beneath the top app bar in both initial onboarding and subsequent profile edit states.
- **Top App Bar Title**: Clean branding title ("Idgie-ing") with back arrow when editing, leaving the full greeting text unclipped inside the spacious welcome card.

---

## 1. Overview & Core Concept

- **What It Does**: Replaces the impersonal "Seeker Profile" / "A little about you" header with an engaging, characterful welcome card from **Idgie-ing**, introducing its creator **KaliMike** and providing the core spiritual mental preparation ("hold that thought when you throw the dice") prior to filling out profile details or casting hexagrams.
- **Target Audience / Persona**: Seekers consulting the I Ching who appreciate thoughtful guidance, clear intention-setting, and a warm, personalized companion persona.
- **Key Value**: Sets an immediate contemplative tone, frames the purpose of the application, and reinforces the core casting ritual (holding a clear question in mind while throwing the coins/dice).

---

## 2. User Experience & Visual Design

### Key User Flows
1. **First-Launch Onboarding**:
   - The user opens the app for the first time and arrives at the Profile setup screen.
   - At the top of the content area, the **Idgie-ing Welcome Card** greets them with a glowing emblem badge, the KaliMike attribution, and the full decision-making invocation.
   - Below the card, the seeker completes the Age, Gender, Education, and Experience fields, with clear indicators that their answers contextualize interpretations without altering hexagram probabilities.
2. **Profile Re-edit / Navigation**:
   - When opened later from the app drawer or settings, the Welcome Card remains as a consistent identity anchor, while the TopAppBar offers a back navigation arrow.

### Visual Identity & Theme
- **Aesthetic Direction**: Meditative Daoist parchment meets modern Material 3 surfaces, featuring deep ink tones, warm bamboo accents, and Imperial Gold highlights.
- **Color Palette**:
  - *Card Container*: `surfaceVariant` with elevated tonal depth and subtle 1.dp border (`ImperialGold.copy(alpha = 0.45f)`).
  - *Accent Badge*: Circular gradient medallion with `Icons.Default.SelfImprovement` or `ChangeCircle`.
  - *Text Colors*: `onSurface` for title and body with high contrast ratio; `primary` for creator attribution chip.
- **Typography & Hierarchy**:
  - Greeting headline: Bold `18.sp` / `24.sp` line height ("Idgie-ing").
  - Companion pill: "Created by KaliMike" in medium `12.sp` subdued gold.
  - Body text: Crisp `14.5.sp` / `21.sp` line height presenting the full quote in natural reading cadence.
  - Focus Tip: Sub-caption badge with a subtle lightbulb / dice indicator ("Hold your question in mind as you cast").
- **Component Styling & Layout**:
  - Rounded corners (`16.dp` to `20.dp`).
  - Balanced vertical rhythm (16.dp internal padding, 16.dp bottom margin before form sections).

---

## 3. Key Product Decisions & Trade-Offs

- **Dedicated Welcome Card vs. Flat Header Text**:
  - *Chosen Approach*: Enclose the greeting inside a distinct elevated card with decorative framing rather than raw body text.
  - *Why*: The multi-sentence greeting has rich storytelling and ritual instructions; placing it in a card distinguishes it from form field instructions and elevates visual hierarchy.
  - *Alternatives Considered*: Putting the entire 35-word message into the 56.dp TopAppBar (causes severe truncation and violates accessibility standards).

- **Header Text on Edit vs. Initial Setup**:
  - *Chosen Approach*: Show the Welcome Card uniformly on both initial launch and profile editing, while standardizing the TopAppBar title to "Idgie-ing".
  - *Why*: Provides consistent brand identity and ensures users returning to edit their profile retain the same warm guidance.

---

## 4. Technical Architecture & Data Strategy

### System Component Diagram

```
┌────────────────────────────────────────────────────────┐
│                      Scaffold                          │
│  TopAppBar: "Idgie-ing" + Back Button (if !firstLaunch)│
├────────────────────────────────────────────────────────┤
│             ProfileScreen Scrollable Column            │
│                                                        │
│  ┌──────────────────────────────────────────────────┐  │
│  │             Idgie-ing Welcome Card               │  │
│  │  [Avatar Icon] Idgie-ing · Created by KaliMike   │  │
│  │                                                  │  │
│  │  "Hi ! I am Idgie-ing, I was created by KaliMike │  │
│  │   to help you make a decision when you most      │  │
│  │   need it! Just think about the question you     │  │
│  │   have and hold that thought when you throw the  │  │
│  │   dice."                                         │  │
│  │                                                  │  │
│  │  [Icon] Focus your question before casting       │  │
│  └──────────────────────────────────────────────────┘  │
│                                                        │
│  ┌──────────────────────────────────────────────────┐  │
│  │ Form Sections: Age, Gender, Education, Experience│  │
│  └──────────────────────────────────────────────────┘  │
│                                                        │
│  [ Save & Begin Divination Button ]                    │
└────────────────────────────────────────────────────────┘
```

### Data Model & State
- **State Store**: `IChingViewModel` persists `UserProfile` (age, gender, education, experience, isProfileCompleted).
- **Presentation Logic**: The welcome card is purely presentational, requiring no migration or database schema change while preserving existing validation logic (`isFormValid`) and navigation callbacks (`onProfileCompleted`, `onBack`).
