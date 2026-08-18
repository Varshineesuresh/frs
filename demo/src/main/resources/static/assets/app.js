// ---------------------------------------------------------------------------
// Shared front-end behavior. This is UI-only mock logic — wire the actions
// marked "TODO: connect to API" up to your real backend endpoints.
// ---------------------------------------------------------------------------

// ---- index.html: role picker ----------------------------------------------
function initRolePicker() {
  const options = document.querySelectorAll('.role-option');
  const input = document.getElementById('selected-role');
  if (!options.length) return;
  options.forEach(opt => {
    opt.addEventListener('click', () => {
      options.forEach(o => o.classList.remove('selected'));
      opt.classList.add('selected');
      if (input) input.value = opt.dataset.role;
    });
  });
}

// ---- donor.html: toggle "new donation" form --------------------------------
function initDonationForm() {
  const toggleBtn = document.getElementById('toggle-donation-form');
  const panel = document.getElementById('donation-form-panel');
  if (!toggleBtn || !panel) return;
  toggleBtn.addEventListener('click', () => {
    panel.style.display = panel.style.display === 'none' ? 'block' : 'none';
    panel.scrollIntoView({ behavior: 'smooth', block: 'start' });
  });

  const form = document.getElementById('donation-form');
  if (form) {
    form.addEventListener('submit', (e) => {
      e.preventDefault();
      // TODO: connect to API - POST /api/donations
      alert('Donation submitted (mock). Wire this up to POST /api/donations.');
      form.reset();
      panel.style.display = 'none';
    });
  }
}

// ---- ngo.html: filter available donations ----------------------------------
function initDonationFilters() {
  const filterForm = document.getElementById('donation-filters');
  if (!filterForm) return;
  const foodTypeSelect = document.getElementById('filter-food-type');
  const cards = document.querySelectorAll('[data-food-type]');

  filterForm.addEventListener('input', () => {
    const val = foodTypeSelect.value;
    cards.forEach(card => {
      const match = val === 'all' || card.dataset.foodType === val;
      card.style.display = match ? '' : 'none';
    });
  });
}

// ---- ngo.html / donor.html: claim / cancel actions (mock) ------------------
function initCardActions() {
  document.querySelectorAll('[data-action="claim"]').forEach(btn => {
    btn.addEventListener('click', () => {
      // TODO: connect to API - POST /api/ngo-requests
      alert('Request sent to donor (mock). Wire this up to POST /api/ngo-requests.');
    });
  });
  document.querySelectorAll('[data-action="cancel"]').forEach(btn => {
    btn.addEventListener('click', () => {
      // TODO: connect to API - PATCH /api/donations/:id { status: 'Cancelled' }
      if (confirm('Cancel this donation?')) {
        alert('Donation cancelled (mock).');
      }
    });
  });
}

document.addEventListener('DOMContentLoaded', () => {
  initRolePicker();
  initDonationForm();
  initDonationFilters();
  initCardActions();
});