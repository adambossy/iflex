from django.shortcuts import render_to_response

def default(request):
    return render_to_response('static/default.html', {})

# Privacy policy
def privacy(request):
    return render_to_response('static/privacy.html', {})

# Site map
def site_map(request):
    return render_to_response('static/site_map.html', {})
    
