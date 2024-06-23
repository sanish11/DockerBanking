# Stage 1: Build the Angular application
FROM node:12 AS build

# Set the working directory
WORKDIR /app

# Install Angular CLI version 12 globally
RUN npm install -g @angular/cli@12

# Install dependencies including querystring
RUN npm install && \
    npm install querystring


# Copy package.json and package-lock.json
COPY package*.json ./

# Copy the rest of the application code
COPY . .

# Build the Angular application
RUN npm run build --prod

# Stage 2: Serve the Angular application with Nginx
FROM nginx:alpine

# Copy the build output to the Nginx HTML directory
COPY --from=build /app/dist /usr/share/nginx/html

# Expose the port on which the application will run
EXPOSE 80

# Start Nginx server
CMD ["nginx", "-g", "daemon off;"]
