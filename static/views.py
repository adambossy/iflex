from django.contrib.auth import authenticate, login
from django.shortcuts import render_to_response
from django.http import HttpResponse

def default(request):
    return render_to_response('static/default.html', {})

# Privacy policy
def privacy(request):
    return render_to_response('static/privacy.html', {})

# Site map
def site_map(request):
    return render_to_response('static/site_map.html', {})

def mockup(request):
    return render_to_response('static/mockup.html', {})

def login(request):
    return render_to_response('static/login.html', {})
    
def auth(request):
    if ('username' in request.POST and 'password' in request.POST):
        username = request.POST['username']
        password = request.POST['password']
        user = authenticate(username=username, password=password)
        if user is not None:
            if user.is_active:
                login(user)
                # Redirect to a success page.
                return HttpResponse("You provided a correct username and password!")
            else:
                # Return a 'disabled account' error message
                return HttpResponse("Your account has been disabled!")
        else:
            # Return an 'invalid login' error message.
            return render_to_response('static/login.html', { 'error_message': "Your username and password were incorrect." })
    return render_to_response('static/login.html', {})

