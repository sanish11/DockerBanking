# Stage 1: Build the Angular application
FROM node:12 AS build

# Set the working directory
WORKDIR /app

# Copy package.json and package-lock.json
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the application code
COPY . .

# Build the Angular application
RUN npm run build --prod

# Stage 2: Serve the Angular application with Nginx
FROM nginx:alpine

# Copy the build output to the Nginx HTML directory
COPY --from=build /app/dist/your-angular-app /usr/share/nginx/html

# Expose the port on which the application will run
EXPOSE 80

# Start Nginx server
CMD ["nginx", "-g", "daemon off;"]